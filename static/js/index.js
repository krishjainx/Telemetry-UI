//////////////////////////////////////////////////////////
// Main html page JS
// Handles all page mechanics.
//////////////////////////////////////////////////////////

// Create an instance of the Telemetry system connected to the local machine
var Telemetry = new TelemetryServer("localhost")

// On page initialization
$(function(){
    // Clear all the data points on page reload
    // After this we request a full data reload
    $(".data-point-raw").each(function(index, element){
        $(this).text("---");
    });

    setupStatusBar();
});

Telemetry.addStatsCallback(function(){
    $("#status-messages").text("Status: "+Telemetry.getStat("numActiveDevices")+" active device(s)");
    $("#status-data").text("("+Telemetry.getStat("numDataPoints")+" data points \/ "+Telemetry.getStat("numRadioPackets")+" packets)")
    if (Telemetry.getStat("hasRadio") == "True") {
        $("#status-radio").text("Radio Link Established");
    } else {
        $("#status-radio").text("No Radio Link");
    }
});

Telemetry.addDataCallback(function(){
    lastDataPoints = Telemetry.getAll();
    for (source in lastDataPoints){
        for (key in lastDataPoints[source]){
            // Update live divs with the data points
            var combinedKey = source+"\\."+key;
            var current = lastDataPoints[source][key].current;
            var min = lastDataPoints[source][key].min;
            var max = lastDataPoints[source][key].max;
            if (current == null){ current = "---"; }
            if (min == null){ min = "---"; }
            if (max == null){ max = "---"; }
            $("#"+combinedKey).text(current);
            $("#"+combinedKey+"\\.min").text(min);
            $("#"+combinedKey+"\\.max").text(max);
        }
    }
});

// Configures the status bar on the side.
// shows a log of all the latest data values.
function setupStatusBar(){
    // Set up status bar toggling
    $(".status-bar-toggle").text("hide");
    $(".status-bar-toggle").click(function(){
        statusBarSetState($(this), $(this).text() == "hide");
    });
    statusBarSetState($("#status-bar-toggle-gps"),true)
    statusBarSetState($("#status-bar-toggle-gyro"),true)
    statusBarSetState($("#status-bar-toggle-alltrax"),true)
    statusBarSetState($("#status-bar-toggle-vesc"),true)
    statusBarSetState($("#status-bar-toggle-battery"),true)
    statusBarSetState($("#status-bar-toggle-throttle"),true)
}

function statusBarSetState(object, state){
    if (state){
        statusBarShow(object);
    } else {
        statusBarHide(object);
    }
}

function statusBarShow(object){
    object.parent().addClass("status-pane-hidden");
    object.text("show");
}

function statusBarHide(object){
    object.parent().removeClass("status-pane-hidden");
    object.text("hide");
}
