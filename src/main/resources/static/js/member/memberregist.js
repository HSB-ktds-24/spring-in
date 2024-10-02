$().ready(function () {
  $("#email").keyup(function () {
    $.get(
      "/member/regist/available",
      { email: $(this).val() },
      function (availableResponse) {
        var email = availableResponse.email;
        var available = availableResponse.available;
        console.log(email);
        console.log(available);
        if (available) {
          console.log($("#email"));
          $("#email").addClass("available");
          $("#email").removeClass("unusable");
          $("input[type=submit]").removeAttr("disabled", "disabled");
        } else {
          $("#email").addClass("unusable");
          $("#email").removeClass("available");
          $("input[type=submit]").attr("disabled", "disabled");
        }
      }
    );
  });
});
