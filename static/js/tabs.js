var currentTab = "";

$(function(){
    // Set the current tab to default
    setTab("dashboard");

    // Set a click listener for all tab objects
    $(".tab").click(function(){
        // Trim the -tab from the name and call setTab
        tabId = this.id.substring(0, this.id.length - 4);
        setTab(tabId);
    })
});


function setTab(tab){
    if (tab == currentTab){
        console.log("ignoring, already on tab "+tab);
        return;
    } else {
        currentTab = tab;
        console.log("Switched to tab "+tab);
    }

    // Set all the tabs to inactive and set the active tab
    $(".tab").removeClass("tab-active").addClass("tab-inactive");
    $("#"+tab+"-tab").removeClass("tab-inactive").addClass("tab-active");

    // Hide all the tab panes, show active tab pane
    $(".tab-pane").hide();
    $("#"+tab+"-tab-pane").show();
}
