
var dashboardChart;
var dashboardChart2;
var chartX = 0;


$(function(){
    setupChart1();
    setupChart2();
});

function setupChart1(){
    var ctx = document.getElementById("dashboardChart1").getContext('2d');
    data = []
    dashboardChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                data: [],
                label: "Battery Voltage",
                borderColor: "#ffff00",
                fill: false,
                pointRadius: 0,
                cubicInterpolationMode: "monotone"
            },{
                data: [],
                label: "Battery Current",
                borderColor: "#00ffff",
                fill: false,
                pointRadius: 0
            },{
                data: [],
                label: "Motor Temp",
                borderColor: "#00ff002",
                fill: false,
                pointRadius: 0
            }]
        },
        options: {
            maintainAspectRatio: false,
            steppedLine: false,
            elements: {
                line: {
                    tension: 0, // disables bezier curves
                }
            }
        }
    });
}
function setupChart2(){
    var ctx = document.getElementById("dashboardChart2").getContext('2d');
    data = []
    dashboardChart2 = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                data: [],
                label: "Motor RPM",
                borderColor: "#ff00ff",
                fill: false,
                pointRadius: 0
            }]
        },
        options: {
            maintainAspectRatio: false,
            steppedLine: false,
            elements: {
                line: {
                    tension: 0, // disables bezier curves
                }
            }
        }
    });
}

function parseChartData(key, value){
    chartX++;
    if (key == "bmvVoltage"){
        addData(dashboardChart, 0,chartX,value);
    }
    if (key == "bmvCurrent"){
        addData(dashboardChart, 1,chartX,value);
    }
    if (key == "motorRpm"){
        addData(dashboardChart2,0,chartX,value);
    }
    if (key == "motorTemp"){
        addData(dashboardChart,2,chartX,value);
    }
}

var maxLength = 20;
function addData(chart, datasetIndex, label, data) {
    if (chart.data.labels.length > maxLength){
        chart.data.labels.shift()
    }
    if (chart.data.datasets[datasetIndex].data.length > maxLength){
        chart.data.datasets[datasetIndex].data.shift()
    }
    chart.data.labels.push(label);
    chart.data.datasets[datasetIndex].data.push(data);
    chart.update();
}
