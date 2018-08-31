<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebSocket广播室</title>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link  href="../static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
    <link  href="../static/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
    <script src="../static/bootstrap/js/jquery-3.3.1.min.js"></script>
    <script  src="../static/bootstrap/js/bootstrap.js"></script>
    <script  src="../static/bootstrap/js/plugins/jquery-validation/jquery.validate.js"></script>
    <script  src="../static/bootstrap/js/plugins/jquery-validation/localization/messages_zh.js"></script>
    <script  src="../static/bootstrap/js/jquery-bootstrap.js"></script>
    <script  src="../static/bootstrap/js/plugins/webSocket/sockjs.min.js"></script>
    <script  src="../static/bootstrap/js/plugins/webSocket/stomp.min.js"></script>
    <script  src="../static/bootstrap/js/plugins/webSocket/socket.min.js"></script>
    <script type="text/javascript">
        $(function () {
         //连接
         function connect() {
               var socket = new SockJS("/endpointWisely");
               stompClient = Stomp.over(socket);
               stompClient._connect({},function (frame){
                   setConnected(True);
                   console.log("connected:"+frame);
                   stompClient.subscribe("/topic/getResponse",function (response) {
                       showResponse(JSON.parse(response.body).responseMessage);
                   })
               })
           };
         //设置连接状态控制显示隐藏
         function setConnected(connected){
             $("#connect").attr("disabled",connected);
             $("#disconnect").attr("disabled",!connected);
             if (!connected){
                 $("#inputDiv").hide();
             }else{
                 $("#inputDiv").show();
             }
             $("#response").html("");
         };
         //显示socket返回消息内容
         function showResponse(message){
             $("#response").html(message);
         }
         //断开连接
         function disconnect() {
           if (stompClient!=null){
               stompClient.disconnect();
           }
           setConnected(false);
           console.log("disconnected!");
         }

        })
    </script>
</head>
<body onload="disconnect()">
    <button id="connect" onclick="connect()" class="menu-button">连接</button>
    <button id="disconnect" onclick="disconnect()" disabled="disabled" class="decrement-button">断开连接</button>
    <div id="inputDiv">
        <span>输入名称:</span><input type="text" id="name"/><br>
        <button id="sendName" onclick="sendName()">发送</button><br>
        <p id="response"></p>
    </div>
</body>
</html>
