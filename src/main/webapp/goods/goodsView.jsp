<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!doctype html>
<html lang="en">

<head>
 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js"
        integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <title>상품 상세보기</title>

    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">


    <style>
        * {
            font-family: 'Jua', sans-serif;
        }

        .wrap {
            margin: auto;
            width: 900px;
        }

        .comment {
            font-weight: bold;
            color: blue;
        }

        .posting-box {
            margin: 10px auto 100px auto;
 
            border-radius: 5px;

            padding: 25px;
        }

        .card-title {
            font-size: 4em;
        }

        .top-img {
            margin-top: 50px;

        }


        img {
            width: 500px;
            height: 500px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="top-img clearfix">
                    <img src="/Users/egg/kosta/Project2/img/1.png">
                </div>
            </div>
            <div class="col">
                <div class="card-body">
                    <a class="card-title">정성한상</a>
                    <p class="card-text">집밥 느낌 그대로, 정성껏 차린 가정식 한상</p>

                </div>
                <div class="posting-box">
                    <div class="form-group">
                        <label for="exampleInputEmail1">배송요일</label>
                        <select class="selectpicker">
                            <option>주 5회 (월~금)</option>
                            <option>주 3회 (월/수/금)</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">배송기간</label>
                        <select class="selectpicker">
                            <option>1주</option>
                            <option>2주</option>
                            <option>4주</option>
                            <option>8주</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">수량</label>

                        <div class="spiner-form-container clearfix">
                            <button class="spiner-minus"><i class="material-icons" id="minus">remove</i></button>
                            <input type="text" class="spiner-text" id="quantity" value="1">
                            <button class="spiner-plus"><i class="material-icons" id="plus">add</i></button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">첫 배송일</label>
                        <input type="password" id="datePicker" class="form-control" placeholder="">
                    </div>
                    <button type="submit" class="btn btn-primary">장바구니 담기</button>
                    <button type="submit" class="btn btn-primary">주문하기</button>
                </div>
            </div>
        </div>
        <div class="row">
            
        </div>
    </div>
</body>

<!-- <script>
    $('#datePicker').datepicker({
        format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
        startDate: '-10d',	//달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
        endDate: '+10d',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
        autoclose: true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
        calendarWeeks: false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
        clearBtn: false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
        datesDisabled: ['2019-06-24', '2019-06-26'],//선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
        daysOfWeekDisabled: [0, 6],	//선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
        daysOfWeekHighlighted: [3], //강조 되어야 하는 요일 설정
        disableTouchKeyboard: false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
        immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
        multidate: false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false 
        multidateSeparator: ",", //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
        templates: {
            leftArrow: '&laquo;',
            rightArrow: '&raquo;'
        }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
        showWeekDays: true,// 위에 요일 보여주는 옵션 기본값 : true
        title: "테스트",	//캘린더 상단에 보여주는 타이틀
        todayHighlight: true,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
        toggleActive: true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
        weekStart: 0,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
        language: "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.

    });//datepicker end
</script> -->
<!-- <script>
    $('.selectpicker').selectpicker({
        style: 'btn-info',
        size: 4
    });
</script> -->

</html>
</html>