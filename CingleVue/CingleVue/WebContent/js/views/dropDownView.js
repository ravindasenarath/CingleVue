var DropDownView = Backbone.View.extend({

	type : "DropDownView",
	el : "#dropdown-container",
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