		var DropDownView = Backbone.View.extend({
			
			type : "DropDownView",
			el : "#dropdown-container",
			template : _.template($("#template-dropDown").html()),
			tagName : "Select",
			className : "",
			
			initialize : function() {
				console.log("Initialize DropDownView");
			},
			
			events : {
				  "change #subject-dropdown" : "dropdownChange"
			},
			
			render : function() {
				var outputHtml = this.template();
				this.$el.html(outputHtml);
				return this;
			},
			
			dropdownChange : function(e) {
				console.log("drop down changed");
				console.log(e.target.value);
			}
			
		});