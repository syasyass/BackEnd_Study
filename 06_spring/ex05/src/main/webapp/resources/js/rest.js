async function rest_get(url) {
 	try {
 		let res = await fetch(url);
 		return await res.json(); 	
 	} catch(e) {
 		console.log(e);
 	} 
 }