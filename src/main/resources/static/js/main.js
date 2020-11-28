function requestSubtypes(typeid) {
	$.get("http://localhost:8090//getSubTypes//{"+ typeid +"}", function(data) {
		var htmlToInsert = "<table>";
		$.each(data,function (index, value) {
			htmlToInsert += "<tr>";
			htmlToInsert += "<td>" +value.id + "</td>";
			htmlToInsert += "<td>" +value.name + "</td>";
			htmlToInsert += "</tr>";
		});
		htmlToInsert = htmlToInsert +"</table>";

		$("#subtypes").html(htmlToInsert);

	});
}