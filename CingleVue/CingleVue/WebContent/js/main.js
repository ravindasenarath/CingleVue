

var AppRouter = Backbone.Router.extend({

	initialize : function() {
		console.log("Init");
	},

	routes : {
		"" : "generateTable",
	},

	generateTable : function() {
		var resultList = new ResultList();

		var resultListView = new ResultListView({
			collection : resultList
		});
		resultListView.render();
		
		var dropDownView = new DropDownView();
		dropDownView.render();
	}

});

tpl.loadTemplates([ 'template-dropDown', 'template-resultItem' ], function() {
	app = new AppRouter();
	Backbone.history.start();
});