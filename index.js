const {app, process, BrowserWindow} = require('electron')
require('electron-reload')(__dirname);
var Chart = require('chart.js');
var child_process = require('child_process');
var kill = require('tree-kill');

let win

function createWindow () {
    // Create the browser window.
    var width = 800;
    var height = 600;
    win = new BrowserWindow({width: width, height: height, minWidth: width, minHeight: height})

    win.loadFile('index.html')

    //win.webContents.openDevTools()

    win.on('closed', () => {
      win = null
    })
}

app.on('ready', createWindow)
app.on('window-all-closed', () => { app.quit(); })
app.on('activate', () => { if (win === null) { createWindow(); }})
app.on('before-quit', function(){
    console.log("Quitting...");
});
