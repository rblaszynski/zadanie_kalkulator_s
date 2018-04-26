<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Salary calculator</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

</head>
<body ng-app="app" class="ng-cloak">
<div class="py-5 text-center">
    <h2>Salary calculator</h2>
    <p class="lead">Enter your daily income and choose country to see how much money you will earn in month</p>
</div>
<div class="generic-container" ng-controller="NBPController as ctrl">
    <div class="container">
        <form>
         <div class="col-md-5 mb-3">
             <label class="control-lable">Country</label>
             <select ng-model="myCode" ng-options="code.name for code in codes" class="custom-select d-block w-100" id="country" required>
                 <option value="">Choose...</option>
             </select>
         </div>
        <div class="col-md-6 mb-3">
            <label class="control-lable">Salary</label>
            <input data-ng-model="ctrl.salary" data-ng-pattern="^[+-]?([0-9]*[.])?[0-9]+$" name="num" class="form-control" placeholder="Enter your daily income" required/>
        </div>
        <div class="col-md-7 mb-3">
            <div class="form-actions floatRight">
                <button type="button" ng-click="ctrl.showRate(myCode.name,ctrl.salary)" class="btn btn-primary btn-sm"
                        ng-disabled="myForm.$invalid">CHECK</button>
            </div>
        </div>
        <div class="col-md-8 mb-3">
        <pre>
            <h2>Wynik: <span ng-bind="ctrl.rate"></span></h2>
        </pre>
        </div>
    </form>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/service/service.js' />"></script>
<script src="<c:url value='/static/js/controller/controller.js' />"></script>
</body>
</html>
