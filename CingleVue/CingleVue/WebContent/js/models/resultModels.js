		

		var Result = Backbone.Model.extend({

			initialize : function() {
				console.log("Movie model created");
			}

		});
		
		var ResultList = Backbone.Collection.extend({
			model : Result,
			url : 'rest/result/get/Reading',

			initialize : function() {
				console.log("Collection Init");
			}

		});