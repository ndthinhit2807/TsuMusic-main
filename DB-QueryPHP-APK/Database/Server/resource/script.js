'use strict';

const password = document.getElementById('password')
const cfmpassword = document.getElementById('cfmpassword')
const form = document.getElementById('form')
const errorElement = document.getElementById('error')


form.addEventListener('submit', (e) => {
  let messages = []
  
	
    
  if (password.value === '' || cfmpassword.value === '') {
    messages.push('Chưa nhập mật khẩu!')
  }
  else
  if (password.value.length < 6 || password.value.length >20) {
    messages.push('Mật khẩu phải lớn hơn 6 ký tự và nhỏ hơn 20 ký tự!')
  }
  else if(password.value.length != cfmpassword.value.length)  
  {   
    messages.push('Mật khẩu vừa nhập không khớp!')
  } 
  else if(password.value.length == cfmpassword.value.length)  
  {   
    alert("Đổi mật khẩu thành công");  
  } 
  if (messages.length > 0) {
    e.preventDefault()	
    errorElement.innerText = messages.join(', ')
  }
})

$(function() {

	// author badge :)
	var author = '<div style="position: fixed;bottom: 0;right: 20px;background-color: #fff;box-shadow: 0 4px 8px rgba(0,0,0,.05);border-radius: 3px 3px 0 0;font-size: 12px;padding: 5px 10px;">By <a href="https://twitter.com/mhdnauvalazhar">@mhdnauvalazhar</a> &nbsp;&bull;&nbsp; <a href="https://www.buymeacoffee.com/mhdnauvalazhar">Buy me a Coffee</a></div>';
	$("body").append(author);

	$("input[type='password'][data-eye]").each(function(i) {
		var $this = $(this),
			id = 'eye-password-' + i,
			el = $('#' + id);

		$this.wrap($("<div/>", {
			style: 'position:relative',
			id: id
		}));

		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-'+i,
		}).css({
				position: 'absolute',
				right: 10,
				top: ($this.outerHeight() / 2) - 12,
				padding: '2px 7px',
				fontSize: 12,
				cursor: 'pointer',
		}));

		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));
		
		var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

		if(invalid_feedback.length ) {
			$this.after(invalid_feedback.clone());
		}
	

		$this.on("keyup paste", function() {
			$("#passeye-"+i).val($(this).val());
		});
		$("#passeye-toggle-"+i).on("click", function() {
			if($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			}else{
				$this.attr('type', 'text');
				$this.val($("#passeye-"+i).val());				
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});
});

