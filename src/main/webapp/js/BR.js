

function loadfirstselect(){

//    var1 = fetch1();
  //  var2= JSON.stringify(var1);
    //document.getElementById("test").innerHTML = var2
    fetch1();
}

function fetch1(){
   fetch('rest/test2')
        .then(function(response){
        return response.json()
        })
       .then(function (myJson) {
           //console.log(myJson);
           var textnode = document.createTextNode(myJson.messages);
           var t2 = JSON.stringify(textnode);
           document.getElementById("test").innerHTML = t2;
       })
}