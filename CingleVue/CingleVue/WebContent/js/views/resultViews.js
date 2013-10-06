		
		var ResultListView = Backbone.View.extend({
			type : "ResultListView",
			el : "#container-movieList",
			//collection:
			initialize : function() {
				console.log("Initializing MovieListView");
				this.collection.on('change',this.render,this);
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
			template : _.template($("#template-movieItem").html()),
			tagName : "tr",
			className : "",
			//el :
			//model :

			initialize : function() {
				console.log("Initialize Item view");
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