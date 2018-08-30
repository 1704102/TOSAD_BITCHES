/**
 *
 */
const baseUrl = "rest/businessRule/";
// define businessRule form


function InitPage(){
// attribute range
	fetch(baseUrl + "arr/all", {
		method : "POST",
		body : JSON.stringify("{'database_id':1}")
	})
	.then(function(response){
		return response.json()
	})
	.then(function(MyJson){
		console.log(MyJson.table)} )
	.catch(function(error){console.log("arr get error: \n" )
	});
//
//fetch(, {
//	method : "POST",
//	body: JSON.stringify(object),
//	headers:{
//		'Content-Type' : 'application/json'
//	}
//})
//.then(function(response){
//	// what will be send back? lets check first
//	console.log("attr_range post" + response);
//	return response.json()})
//.then(function(error)){
//	console.log(error)
//})
// attribute compare


// attribute other
}
InitPage();
