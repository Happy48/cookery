var co=4;
var step=4;

function addComponent(){
    co=co+1;
    var coid='co'+co;
    $("#componentBody").append("<tr id='"+coid+"'>\n" +
        "<td><input type=\"text\" placeholder=\"食材：如鸡蛋\" style=\"width:100%;outline:none\">\n" +
        "</td><td><input type=\"text\" placeholder=\"用量：如一只\" style=\"width:100%;outline:none\">\n" +
        "</td><td><img src=\"images/close.png\" draggable=\"false\" onclick='deleteCo("+co+")'></td></tr>");
}

function addStep(){
    step=step+1;
    var stepid = 'step'+step;
    $("#stepBody").append("<tr id='"+stepid+"'>\n" +
        "<td><h4>"+step+"</h4></td><td>\n" +
        "<textarea style=\"width: 400px;height:200px;outline:none\" value=\" \" onfocus=\"this.value='';\" onblur=\"if (this.value == '') {this.value = '';}\"></textarea>\n" +
        "</td><td><div class=\"imageFileInput\"><input class=\"fileInput\" type=\"file\"  name=\"\">\n" +
        "</div></td><td><img src=\"images/closeB.png\" style=\"padding-top: 60px\" draggable=\"false\" onclick='deleteStep("+step+")'>\n" +
        "</td></tr>");
}

function deleteStep (num) {
    var tobeDelete='step'+num;
    document.getElementById(tobeDelete).remove();
    // var tmp;
    // for(var i=step;i>num;i--){
    //     tmp='step'+i;
    //     var numStep = parseInt(document.getElementById(tmp).firstElementChild.innerHTML);
    //     numStep = numStep-1;
    //     document.getElementById(tmp).firstElementChild.innerHTML = numStep.toString();
    // }有问题
}

function deleteCo(num){
    var tobeDelete='co'+num;
    document.getElementById(tobeDelete).remove();
}