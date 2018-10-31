const {app, BrowserWindow} = require('electron')
require('electron-reload')(__dirname);
var Chart = require('chart.js');

let win

function createWindow () {
    // Create the browser window.
    win = new BrowserWindow({width: 1024, height: 768, minWidth: 800, minHeight: 600})

    win.loadFile('index.html')

    //win.webContents.openDevTools()

    win.on('closed', () => {
      win = null
    })
}

app.on('ready', createWindow)
app.on('window-all-closed', () => { app.quit() })
app.on('activate', () => { if (win === null) { createWindow() }})
