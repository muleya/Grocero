controllers.controller('MasterListController',
		['$scope','ProductResource','MasterListResource','$location','$filter',
		 function($scope,Product,MasterList,$location,$filter){
	var self = this;
	self.listName = $filter('date')(new Date(),"dd-MMM-yyyy");
	$scope.masterList = new MasterList({name:"Master List",items:[]});
	$scope.message = "";

	$scope.saveList = function(){
		// TODO AUTH - Change the below id to customerId once the authentication is inplace
		$scope.masterList.$save({id:"59c1f7a0e4b01ba052e3b2d8"},function(data,headers){
			$scope.masterList = new MasterList({name:"Master List",items:[]});
			$scope.message = "MasterList Saved successfully !!!";
		},function(httpResponse){
			let data = httpResponse.data;
			$scope.message = data.message;
		});
	}

	$scope.addItemToList = function (item){
		$scope.masterList.items.push(item.name);
	}

	$scope.isNotEnlisted = function(item){
		return $scope.masterList.items.indexOf(item) == -1;
	}

}]);
