
var dashboardChartTop;
var dashboardChartBottom;

Chart.defaults.global.plugins.streaming = {
    duration: 10000,
    ttl:11000,
    delay:500,
    refresh:100
}
Chart.defaults.global.defaultFontFamily = '"UbuntuMono",sans-serif';

$(function(){
    setupChartTop();
    setupChartBottom();
    $("#dashboardAlarms").click(function(){
        setTab("alarms");
    });
});

function setupChartTop(){
    var ctx = document.getElementById("dashboardChart1").getContext('2d');
    data = []
    dashboardChartTop = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                data: [],
                label: "Battery Voltage",
                borderColor: "#ffff00",
                fill: false,
                pointRadius: 0,
                lineTension: 0,
                borderWidth:2,
                yAxisID: "y-axis-left"
            },{
                data: [],
                label: "Battery Current",
                borderColor: "#00ffff",
                fill: false,
                pointRadius: 0,
                lineTension: 0,
                borderWidth:2,
                yAxisID: "y-axis-right"
            }]
        },
        options: {
            maintainAspectRatio: false,
            scales: {
                xAxes: [{
                    type: 'realtime',
                    ticks: {
                        minRotation: 0,
                        maxRotation: 0
                    }
                }],
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Battery Voltage (Volts)',
                        fontFamily: "Ubuntu"
                    },
                    position: "left",
                    id: "y-axis-left",
                    ticks: {
                        beginAtZero: true,
                        suggestedMax: 40
                    }
                },{
                    scaleLabel: {
                        display: true,
                        labelString: 'Battery Current (Amps)',
                        fontFamily: "Ubuntu"
                    },
                    position: "right",
                    id: "y-axis-right",
                    ticks: {
                        beginAtZero: false,
                        suggestedMin: -10,
                        suggestedMax: 0,
                        reverse:true
                    }
                }]
            },
            tooltips: {enabled: false},
            hover: {mode: null},
            legend: {
                labels: {
                    fontFamily: "'Ubuntu','sans-serif'"
                }
            }
        }
    });
}
function setupChartBottom(){
    var ctx = document.getElementById("dashboardChart2").getContext('2d');
    data = []
    dashboardChartBottom = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                data: [],
                label: "Motor RPM",
                borderColor: "#4286f4",
                fill: false,
                pointRadius: 0,
                lineTension: 0,
                borderWidth:2,
                yAxisID: "y-axis-left"
            },{
                data: [],
                label: "Prop RPM",
                borderColor: "#414ff4",
                fill: false,
                pointRadius: 0,
                lineTension: 0,
                borderWidth:2,
                yAxisID: "y-axis-left"
            },{
                data: [],
                label: "GPS Speed",
                borderColor: "#4cf441",
                fill: false,
                pointRadius: 0,
                lineTension: 0,
                borderWidth:2,
                yAxisID: "y-axis-right"
            }]
        },
        options: {
            maintainAspectRatio: false,
            scales: {
                xAxes: [{
                    type: 'realtime',
                    ticks: {
                        minRotation: 0,
                        maxRotation: 0
                    }
                }],
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Speed (Rpm)',
                        fontFamily: "Ubuntu"
                    },
                    position: "left",
                    id: "y-axis-left",
                    ticks: {
                        beginAtZero: true,
                        suggestedMax: 3500
                    }
                },{
                    scaleLabel: {
                        display: true,
                        labelString: 'Speed (mph)',
                        fontFamily: "Ubuntu"
                    },
                    position: "right",
                    id: "y-axis-right",
                    ticks: {
                        beginAtZero: true,
                        suggestedMax:10
                    }
                }]
            },
            tooltips: {enabled: false},
            hover: {mode: null},
            legend: {
                labels: {
                    fontFamily: "Ubuntu"
                }
            }
        }
    });
}
// Chart 1: battery voltage, battery current
// Chart 2: motor rpm, prop rpm, gps speed

Telemetry.addDataPointCallback("bmvVoltage",function(){
    dashboardChartTop.data.datasets[0].data.push({
        x: Date.now(),
        y: Telemetry.get("bmvVoltage")
      });
});

Telemetry.addDataPointCallback("bmvCurrent",function(){
    dashboardChartTop.data.datasets[1].data.push({
        x: Date.now(),
        y: Telemetry.get("bmvCurrent")
      });
});

Telemetry.addDataPointCallback("motorRpm",function(){
    dashboardChartBottom.data.datasets[0].data.push({
        x: Date.now(),
        y: Telemetry.get("motorRpm")
      });
});

Telemetry.addDataPointCallback("propRpm",function(){
    dashboardChartBottom.data.datasets[1].data.push({
        x: Date.now(),
        y: Telemetry.get("propRpm")
      });
});

Telemetry.addDataPointCallback("gpsSpeed",function(){
    dashboardChartBottom.data.datasets[2].data.push({
        x: Date.now(),
        y: Telemetry.get("gpsSpeed")
      });
});
