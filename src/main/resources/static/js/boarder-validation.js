/**
 * 입력 항목 validation
 * @returns {boolean}
 */
function invalid(){
    let check = true;
    let emailValid = true;
    let passwdValid = true;

    const regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
    const regPasswd = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;

    //이메일 형식 확인
    if (regEmail.test($("#email").val()) === false) {
        console.log(1);
        $("#email").addClass('is-invalid');
        $("#email").removeClass('is-valid');
        $(".email-feedback").text("이메일 형식이 아닙니다.");

        emailValid = false;
    }
    //이메일 값 null 확인
    if ($("#email").val() == '') {
        console.log(2);
        $("#email").addClass('is-invalid');
        $("#email").removeClass('is-valid');
        $(".email-feedback").text("이메일을 입력 바랍니다.");
        emailValid = false;
    }

    //비밀번호 형식 확인
    if (regPasswd.test($("#passwd").val()) === false) {
        console.log(3);
        $("#passwd").addClass('is-invalid');
        $("#passwd").removeClass('is-valid');
        $(".passwd-feedback").text("잘못된 비밀번호 형식입니다. (문자 + 숫자 포함 9-16자리)");

        passwdValid = false;
    }

    //비밀번호 null 값 확인
    if ($("#passwd").val() == '') {
        console.log(4);
        $("#passwd").addClass('is-invalid');
        $("#passwd").removeClass('is-valid');
        $(".passwd-feedback").text("비밀번호를 입력 바랍니다.");
        passwdValid = false;
    }

    //이메일 유효성 통과시 유효성 success 처리
    if (emailValid) {
        console.log(5);
        $("#email").removeClass('is-invalid');
        $("#email").addClass('is-valid');
    }

    //비밀번호 유효성 통과시 유효성 success 처리
    if (passwdValid) {
        console.log(6);
        $("#passwd").removeClass('is-invalid');
        $("#passwd").addClass('is-valid');
    }

    //이메일, 비밀번호 유효성 둘 중 하나라도 실패 시 false 리턴
    if (!emailValid || !passwdValid) check = false;
    return check;
}