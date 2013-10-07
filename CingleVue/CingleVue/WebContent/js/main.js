//*************************************************************
var Result = Backbone.Model.extend({
	// url : 'rest/result/get/Numeracy',

	initialize : function() {
		console.log("Movie model created");
	}

});

// *************************************************************
var ResultList = Backbone.Collection.extend({
	model : Result,
	url : 'rest/result/get/Reading',

	initialize : function() {
		console.log("Collection Init");
	}

});

// *************************************************************

var ResultListView = Backbone.View.extend({
	type : "ResultListView",
	el : "#container-movieList",
	// collection:
	initialize : function() {
		console.log("Initializing MovieListView");
		//this.collection.on('change', this.render, this);
		_.bindAll(this, "render");
		this.collection.fetch({
			success : this.render
		});
	},

	render : function() {
		_.each(this.collection.models, this.processMovie, this);
	},

	processMovie : function(movie) {
		var childResultItemView = new ResultItemView({
			model : movie
		});
		childResultItemView.render();
		this.$el.append(childResultItemView.el);
	}
});

//*************************************************************
var ResultItemView = Backbone.View.extend({
	type : "ResultItemView",
	//template : _.template($("#template-resultItem").html()),
	//template : _.template(tpl.get('template-resultItem')),
	tagName : "tr",
	className : "",
	//el :
	//model :

	initialize : function() {
		console.log("Initialize Item view");
		this.template = _.template(tpl.get('template-resultItem'));
	},

	render : function() {
		console.log("Success call back to view render");
		this.$el.empty();
		var outputHtml = this.template(this.model.toJSON());
		this.$el.html(outputHtml);
		return this;
	},

	modelChanged : function(model, changes) {
		this.render();
	},

});

var DropDownView = Backbone.View.extend({
	
	type : "DropDownView",
	el : "#dropdown-container",
	//template : _.template($("#template-dropDown").html()),
	//template : _.template(tpl.get('template-dropDown')),
	tagName : "Select",
	className : "",
	
	initialize : function() {
		console.log("Initialize DropDownView");
		this.template = _.template(tpl.get('template-dropDown'));
	},
	
	events : {
		  "change #subject-dropdown" : "dropdownChange"
	},
	
	render : function() {
		console.log("el : " + this.$el);
		var outputHtml = this.template();
		this.$el.html(outputHtml);
		return this;
	},
	
	dropdownChange : function(e) {
		console.log("drop down changed");
		console.log(e.target.value);
	}
	
});

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