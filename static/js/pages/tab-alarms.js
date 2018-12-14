var alarms = {};
var firstAlarmUpdate = true;

function updateAlarms(){
    if (firstAlarmUpdate){
        $("#alarm-container").html("")
        alarms = Telemetry.getAllAlarms();
        for (var alarmKey in alarms) {
            if (alarms.hasOwnProperty(alarmKey)) {
                $("#alarm-container").append("<div class=\"alarm\" id=\"alarm-"+alarmKey+"\"></div>")
            }
        }
        firstAlarmUpdate = false;
    }
    alarms = Telemetry.getAllAlarms();
    for (var alarmKey in alarms) {
        if (alarms.hasOwnProperty(alarmKey)) {
            $("#alarm-"+alarmKey).html("<h3>"+alarmKey+"</h3><span>state = "+alarms[alarmKey].state+", value = ["+alarms[alarmKey].value+"], alarm range = ["+alarms[alarmKey].range_min+","+alarms[alarmKey].range_max+"]</span>");
            if (alarms[alarmKey].state == true){
                $("#alarm-"+alarmKey).removeClass("alarm-inactive").addClass("alarm-active");
            } else {
                $("#alarm-"+alarmKey).removeClass("alarm-active").addClass("alarm-inactive");
            }
        }
    }
}

Telemetry.addAlarmCallback(function(){
    updateAlarms();

    // Update alarm header
    $("#alarm-header").text("Alarms ("+Telemetry.getNumAlarms()+" active)");
    $("#numActiveAlarms").text(Telemetry.getNumAlarms());
    if (Telemetry.getNumAlarms() > 0){
        $("#dashboardAlarms").addClass("dashboardAlarmsActive")
    } else {
        $("#dashboardAlarms").removeClass("dashboardAlarmsActive")
    }
});
