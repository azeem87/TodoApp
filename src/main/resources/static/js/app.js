var todoAppModule = angular.module("todoApp", ["ngResource"])
.constant("baseUrl", "todos/")
.controller("ToDoCtrl", function ($scope, $http, $resource, baseUrl) {

	$scope.todosResource = $resource(baseUrl + ":id", { id: "@id" },
            { add: { method: "POST" }, query:  {method:'GET', isArray:true} });
	
	//fetches all todo's list
	$scope.listAll = function () {
        $scope.todos = $scope.todosResource.query();
    }
	
	//add new todo item
	$scope.addTodo = function (description) {
		
		var todoItem = {
				action : description,
				done : false,
				status : "Pending"
		};
		
        new $scope.todosResource(todoItem).$add().then(function (newTodo) {
            $scope.todos.push(newTodo);
            $scope.descriptionText = "";
        });
    }
	
	//delete todo item
	$scope.deleteItem = function(todoItem) {
		
		$http.delete(baseUrl+todoItem.id)
        .success(function(data) {
            $scope.todos = data;
            console.log(data);
        })
        .error(function(data) {
            console.log('Error: ' + data);
        });
		
	}
	
	$scope.onKeyPress = function(keyEvent) {
		if (keyEvent.which === 13){
			$scope.addTodo($scope.descriptionText);
		}
	}

	$scope.competeTodo = function(item) {
		item.status = item.done ? "Completed" : "Pending";
	}
	
    //pull all todo items
    $scope.listAll();
	
});