var lastDataPoints = {};
var numDataPoints = 0;
var numDataPackets = 0;

$(function(){
    // Clear all the data points on page reload
    // After this we request a full data reload
    $(".data-point-raw").each(function(index, element){
        $(this).text("---");
    });

    // Set up status bar toggling
    $(".status-bar-toggle").text("hide");
    $(".status-bar-toggle").click(function(){
        statusBarSetState($(this), $(this).text() == "hide");
    });

    setInterval(function() {
        $.getJSON("http://localhost:5000/live", function(data){
            for (var key in data) {
                if (data.hasOwnProperty(key)) {
                    if (data[key] == "None") {
                        data[key] = "---"
                    }
                    receiveDataPoint("telemetry",key,data[key]);
                }
            }
        });
        $.getJSON("http://localhost:5000/stats", function(data){
            for (var key in data) {
                if (data.hasOwnProperty(key)) {
                    if (data[key] == "None") {
                        data[key] = "---"
                    }
                    receiveDataPoint("stats",key,data[key]);
                }
            }
            updateStatusBar();
        });
  }, 500);
});

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

// Receives a data point eg
// motor, motorTemp, 120.0
function receiveDataPoint(source,key,value){

    // Save to dictionary of the latest values
    if (!(source in lastDataPoints)){
        lastDataPoints[source] = {};
    }
    lastDataPoints[source][key] = value;

    // Update divs with the id
    var combinedKey = source+"\\."+key;
    $("#"+combinedKey).text(lastDataPoints[source][key]);
}

function updateStatusBar(){
        $("#status-messages").text("Status: "+lastDataPoints.stats.numActiveDevices+" active device(s)");
        $("#status-data").text("("+lastDataPoints.stats.numDataPoints+" data points \/ "+lastDataPoints.stats.numRadioPackets+" packets)")
        if (lastDataPoints.stats.hasRadio == "True") {
            $("#status-radio").text("Radio Link Established");
        } else {
            $("#status-radio").text("No Radio Link");

        }
}
