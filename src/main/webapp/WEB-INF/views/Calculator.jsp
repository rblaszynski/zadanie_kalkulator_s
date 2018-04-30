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
    <h2>Kalkulator wynagrodzeń</h2>
    <p class="lead">Wybierz kraj, wprowadź dzienne zarobki i sprawdź ile zarobisz</p>
    <hr>
</div>

<div class="generic-container" data-ng-controller="Controller as ctrl">
    <div class="container">
        <form name="form">
            <div class="col-md-5 mb-3">
                <label for="country">Kraj: </label><select data-ng-model="myCode"
                                                           data-ng-options="code.name for code in codes"
                                                           class="custom-select d-block w-100" id="country" required>
                <option value="">Wybierz...</option>
            </select>
            </div>

            <div class="col-md-5 mb-3">
                <label class="control-lable">Dzienna stawka brutto: </label>
                <div class="input-group">
                    <input type="text" data-ng-model="ctrl.salary" id="input" name="input" pattern="^\d+(\.\d{1,2})?$"
                           class="form-control" placeholder="Wpisz dzienną stawkę brutto" required/>
                    <div class="input-group-append">
                        <span class="input-group-text" id="basic-addon2">{{myCode.code}}</span>
                    </div>
                </div>
            </div>

            <div class="col-md-6 mb-3">
                <div class="form-actions floatRight">
                    <button type="button" data-ng-click="ctrl.showRate(myCode.code,ctrl.salary)"
                            class="btn btn-primary btn-sm" data-ng-disabled="form.$invalid"> SPRAWDŹ
                    </button>
                </div>
            </div>

            <div class="col-md-7 mb-3">
                <h4>{{ctrl.calcResult}}</h4>
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