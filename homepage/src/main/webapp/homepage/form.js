function confirmLogin() {
          if(document.login_form.id.value === ""){
                  alert("아이디를 입력하세요.");
                  document.login_form.id.focus();
                  return;
          }

          if(document.login_form.pw.value === ""){
                  alert("비밀번호를 입력하세요.");
                  document.login_form.pw.focus();
                  return;
          }

          document.login_form.submit();
  }

  function confirmJoin() {
          if(document.join_form.id.value === ""){
                  alert("아이디를 입력하세요.");
                  document.join_form.id.focus();
                  return;
          }

          if(document.join_form.pw.value === ""){
                  alert("비밀번호를 입력하세요.");
                  document.join_form.pw.focus();
                  return;
          }

          if(document.join_form.name.value === ""){
                  alert("이름을 입력하세요.");
                  document.join_form.name.focus();
                  return;
          }

          if(document.join_form.email.value === ""){
                  alert("이메일 입력하세요.");
                  document.join_form.email.focus();
                  return;
          }

          if(document.join_form.address.value === ""){
                  alert("주소를 입력하세요.");
                  document.join_form.address.focus();
                  return;
          }
          document.join_form.submit();
  }


  function confirmModify() {
          if(document.modify_form.pw.value === ""){
                  alert("비밀번호를 입력하세요.");
                  document.modify_form.pw.focus();
                  return;
          }

          if(document.modify_form.email.value === ""){
                  alert("이메일 입력하세요.");
                  document.modify_form.email.focus();
                  return;
          }

          if(document.modify_form.address.value === ""){
                  alert("주소를 입력하세요.");
                  document.modify_form.address.focus();
                  return;
          }
          document.modify_form.submit();
  }