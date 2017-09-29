package com.sf.login;


//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

/**
 * Created by lenovo on 2017/9/28.
 * 水表数据上报、命令响应的报文解析
 */
public class ReportDecode {

    /**
     * 水量计量单位:m3
     */
    float mUnit = 0.1f;

    /**
     * 消息类型：
     *          设备上传数据      固定："deviceReq"
     *          设备响应服务器     固定："deviceRsp"
     */
    private String msgType = "deviceReq";
    /**
     * 数据标识：水表上传数据
     */
    private byte[] bDeviceReq = {20,00}; //20 00 数据标识  20 00 水表主动上报数据

    /**
     * 标识后面是否还有帧数据
     */
    private int hasMore = 0;
    /**
     * 错误代码
     */
    private int errcode = 0;
    /**
     * 数据标识：水表响应服务器的数据
     */
    private byte bDeviceRsp ;



    //****************start  serviceId = WaterMeter (对应的profile文件中字段) 水表上传数据字段**************************

    /**
     * 上报时间
     */
    private String reportTime;
    /**
     * 累计流量
     */
    private int totalFlow;
    /**
     * 累计正流
     */
    private int totalPositiveFlow;
    /**
     * 累计逆流
     */
    private int totalNegativeFlow;
    /**
     * 信号强度
     */
    private int singalStrength;
    /**
     * 电池电压
     */
    private int batteryVoltage;
    /**
     * 电表状态
     */
    private String meterStatus;
    /**
     * 数据采集时间
     */
    private String dataGatherTime;
    /**
     * 日累计正流
     */
    private int dailyPositiveFlow;
    /**
     * 日累计逆流
     */
    private int dailyNegativeFlow;
    /**
     * 日流量峰值
     */
    private int dailyPeakFlow;
    /**
     * 日流峰值发生的时间
     */
    private String dailyPeakFlowTime;

    /**
     * 间隔时间内的流量
     *  对应到profile文件中字段的类型 datatype 为  string list：["str1","str2","str3"]
     */
    private List<String> dailyIntervalFlowList;
    /**
     * 间隔计量流量起始时间
     */
    private String intervalFlowStartTime;
    /**
     * 信号质量
     */
    private int signalQuality;
    /**
     * 信噪比
     */
    private int signalNoiseRatio;
    /**
     * 覆盖等级
     */
    private int coverageLevel;
    /**
     * crc校验码
     */
    private int checkCode;
    /**
     * 接受符
     */
    private int endCode;



    //****************end serviceId = WaterMeter (对应的profile文件中字段) 水表上传数据字段 **************************




    /**
     * @param binaryData 设备发送给平台coap报文的payload部分 长度：163  [0] - [162]
     *                   水表数据上传入参（binargyData）：
     *                   68 10 37 15 20 09 17 01 42 02 96 20 00 01 27 58 07 26 09 17
     *                   00 00 52 6C 01 20 00 17 09 26 0C 30 00 00 0C 30 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 25 09 17 13 79
     *                   00 3A 16
     *
     *                   解析
     *                   68 帧起始符    [0]
     *                   10 仪表类型    [1]
     *                   37 15 20 09 17 01 42  （BCD）地址域--  4201：厂商代码 ；1709201537 地址     [8]
     *                   02 控制码 000 00010（D76543210）：   [9]
     *                          D7:   		0 — 由主站发出的控制帧;1 — 由从站发出的应答帧。
     *                          D6:     	0 — 通讯正常;  1 — 通讯异常。
     *                          D5:    		0 — 无后续帧;1 — 有后续帧。
     *                          D4 – D0:   	00001:  读数据; 00010:  水表上报数据; 00100:  写数据;
     *
     *                   96 数据长度  96H = 150（十进制）    [10]
     *                   20 00 数据标识  20 00 水表主动上传数据     [12]
     *                   01 包号      [13]
     *                   27 58 07 26 09 17  (BCD）上报时间（17年09月26号 07:58:27）       [19]
     *                   0C 30 00 00 累计流量       [23]
     *                   0C 30 00 00 累计正流       [27]
     *                   00 00 00 00 累计逆流       [31]
     *                   52 	    信号强度        [32]
     *                   6C 01	    电池电压        [34]
     *                   20 00 	    仪表状态 （参考NB-io 水表协议文件）   [36]
     *                              20: 0010 0000   (D15-D8) 静态欠压
     *                              00: 0000 0000  （D7-D0）
     *                   17 09 26    数据采集时间（BCD）17年09月26号       [39]
     *                   00 00 00 00 日累计正流              [43]
     *                   00 00 00 00 日累计逆流              [47]
     *                   00 00       日最高流量              [49]
     *                   00 00 00 00 00 00 日最高流量时间（BCD 年月日时分秒）  [55]
     *                   00 00 第1时段流量           [57]
     *                   00 00 第2时段流量           [59]
     *                   00 00                       [61]
     *                   00 00 第i时段流量
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00
     *                   00 00 00 00                [151]
     *                   00 00 00 25 09 17 间隔计量流量起始时间（17年09月25号 00:00:00）   [157]
     *                   13 信号质量        [158]
     *                   79 信噪比          [159]
     *                   00 覆盖等级        [160]
     *                   3A crc校验码       [161]
     *                   16 结束符          [162]
     *
     */
//    public ReportDecode(byte[] binaryData) {
//        int lastCheckIndex = binaryData.length - 3;
//        // 判断检验结果
//        if (isCrcCheckCorrect(binaryData,0,lastCheckIndex,lastCheckIndex + 1)){
//            // 判断数据标识
//            if ((binaryData[11] == bDeviceReq[0]) && (binaryData[12] == bDeviceReq[1])){
//                //如果为20 00 则是水表主动上传数据,解析水表数据上传的数据成json
//                //上报时间
//                reportTime = binaryData[19]+""+binaryData[18]+""+binaryData[17]+""+binaryData[16]+""+binaryData[15]+""+binaryData[14];
////                totalFlow =
//
//            }
//
//        }
//
//
//    }
//
//    /**
//     * 检验crc校验是否正确
//     * @param binaryData 原始数据
//     * @param startCheckIndex 开始校验位置
//     * @param lastCheckIndex 最后校验位置
//     * @param checkCodePosition 校验码位置
//     * @return
//     */
//    public static boolean isCrcCheckCorrect(byte[] binaryData,int startCheckIndex,int lastCheckIndex,int checkCodePosition){
//        byte curCheckCode = 0x00;
//        byte supposeCheckCode = binaryData[checkCodePosition];
//        for (int i = startCheckIndex; i < lastCheckIndex + 1 ; i++){
//            curCheckCode += binaryData[i];
//        }
//        return curCheckCode == supposeCheckCode;
//    }
//
//    public static void main(String args[]){
////        byte test = 0x19;
////        System.out.print(test+"");
////        byte[] needCheckArr ={0x68,0x10,0x37,0x15,0x20,0x09,0x17,0x01,0x42,0x02,0x96,0x20,0x00,0x01,0x27,0x58,0x07,0x26,0x09,0x17,0x0C,0x30,0x00,0x00,0x0C,0x30,0x00,0x00,0x00,0x00,0x00,0x00,0x52,0x6C,0x01,0x20,0x00,0x17,0x09,0x26,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x25,0x09,0x17,0x13,0x79,0x00};
////        byte[] needCheckArr = {68,10,37,15,20,0x09,17,01,42,02,96,20,00,01,27,58,07,26,0x09,17,0x0C,30,00,00,0x0C,30,00,00,00,00,00,00,52,0x6C,01,20,00,17,0x09,26,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,00,25,0x09,17,13,79,00};
////        byte[] needCheckArr = {0x09};
////        byte supposeCheckCode = 0x3A;
////        boolean crcCheckCorrect = isCrcCheckCorrect(needCheckArr, supposeCheckCode);
////        System.out.println("crcCheckCorrect:"+crcCheckCorrect);
//    }
//
//    /**
//     * 组成ObjectNode对象
//     * @return
//     */
//    public ObjectNode toJsonNode() {
//        try {
//            //组装body体
//            ObjectMapper mapper = new ObjectMapper();
//            ObjectNode root = mapper.createObjectNode();
//
//            // root.put("identifier", this.identifier);
//            root.put("msgType", this.msgType);
//
//            //根据msgType字段组装消息体
//            if (this.msgType.equals("deviceReq")) {
////                root.put("hasMore", this.hasMore);
//                ArrayNode arrynode = mapper.createArrayNode();
//
//                //serviceId=Brightness 数据组装
//                ObjectNode brightNode = mapper.createObjectNode();
//                brightNode.put("serviceId", "WaterMeter");
//                ObjectNode brightData = mapper.createObjectNode();
////                brightData.put("brightness", this.brightness);
//                brightNode.put("serviceData", brightData);
//                arrynode.add(brightNode);
//                //serviceId=Electricity 数据组装
//                ObjectNode electricityNode = mapper.createObjectNode();
//                electricityNode.put("serviceId", "Electricity");
//                ObjectNode electricityData = mapper.createObjectNode();
////                electricityData.put("voltage", this.voltage);
////                electricityData.put("current", this.current);
////                electricityData.put("frequency", this.frequency);
////                electricityData.put("powerfactor", this.powerfactor);
//                electricityNode.put("serviceData", electricityData);
//                arrynode.add(electricityNode);
//                //serviceId=Temperature 数据组装
//                ObjectNode temperatureNode = mapper.createObjectNode();
//                temperatureNode.put("serviceId", "Temperature");
//                ObjectNode temperatureData = mapper.createObjectNode();
////                temperatureData.put("temperature", this.temperature);
//                temperatureNode.put("serviceData", temperatureData);
//                arrynode.add(temperatureNode);
//
//                //serviceId=Connectivity 数据组装
//                ObjectNode ConnectivityNode = mapper.createObjectNode();
//                ConnectivityNode.put("serviceId", "Connectivity");
//                ObjectNode  ConnectivityData = mapper.createObjectNode();
//                ConnectivityData.put("signalStrength", 5);
//                ConnectivityData.put("linkQuality", 10);
//                ConnectivityData.put("cellId", 9);
//                ConnectivityNode.put("serviceData", ConnectivityData);
//                arrynode.add(ConnectivityNode);
//
//                //serviceId=battery 数据组装
//                ObjectNode batteryNode = mapper.createObjectNode();
//                batteryNode.put("serviceId", "battery");
//                ObjectNode batteryData = mapper.createObjectNode();
//                batteryData.put("batteryVoltage", 25);
//                batteryData.put("battervLevel", 12);
//                batteryNode.put("serviceData", batteryData);
//                arrynode.add(batteryNode);
//
//                root.put("data", arrynode);
//
//            } else {
////                root.put("errcode", this.errcode1111);
//                //此处需要考虑兼容性，如果没有传mid，则不对其进行解码
////                if (isContainMid) {
////                    root.put("mid", this.mid);//mid
////                }
//                //组装body体，只能为ObjectNode对象
//                ObjectNode body = mapper.createObjectNode();
//                body.put("result", 0);
//                root.put("body", body);
//            }
//            return root;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


}

