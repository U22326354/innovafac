"use strict";

// Setting Color

$(window).resize(function () {
	$(window).width();
});

// carga inicial
$(document).ready(function() {
    var colorSidebar = localStorage.getItem('sidebarColor');
    var colorLogoHeader = localStorage.getItem('logoHeaderColor');
	var TopBarColor= localStorage.getItem('TopBarColor');
	var bgColor = localStorage.getItem('bodyColor');

    if (colorSidebar) {
        $('.sidebar').attr('data-background-color', colorSidebar);
        $('.changeSideBarColor[data-color="' + colorSidebar + '"]').addClass("selected");
    }

	if( colorLogoHeader){
		$('.logo-header').attr('data-background-color', colorLogoHeader);
		$('.changeLogoHeaderColor[data-color="' + colorLogoHeader + '"]').addClass("selected");
	}

	if(TopBarColor){
		$('.main-header .navbar-header').attr('data-background-color', TopBarColor);
	}

	if(bgColor){
		$('body').attr('data-background-color', bgColor);
	}else{
		$('body').removeAttr('data-background-color');
	}
});

// backgorund color
$('.changeBodyBackgroundFullColor').on('click', function () {
	if ($(this).attr('data-color') == 'default') {
		$('body').removeAttr('data-background-full');
	} else {
		$('body').attr('data-background-full', $(this).attr('data-color'));
	}

	$(this).parent().find('.changeBodyBackgroundFullColor').removeClass("selected");
	$(this).addClass("selected");
	layoutsColors();
});

// change logo header localstorage
$('.changeLogoHeaderColor').on('click', function () {
	var selectedColor= $(this).attr('data-color');
	if (selectedColor == 'default') {
		$('.logo-header').removeAttr('data-background-color');
		localStorage.removeItem('logoHeaderColor'); 
	} else {
		localStorage.setItem('logoHeaderColor', selectedColor);
		$('.logo-header').attr('data-background-color', selectedColor);
	}

	$(this).parent().find('.changeLogoHeaderColor').removeClass("selected");
	$(this).addClass("selected");
	customCheckColor();
	layoutsColors();
});

$('.changeTopBarColor').on('click', function () {
	var selectedColor = $(this).attr('data-color');

	if (selectedColor == 'default') {
		localStorage.removeItem('TopBarColor'); 
		$('.main-header .navbar-header').removeAttr('data-background-color');

	} else {
		localStorage.setItem('TopBarColor', selectedColor);
		$('.main-header .navbar-header').attr('data-background-color', $(this).attr('data-color'));
	}

	$(this).parent().find('.changeTopBarColor').removeClass("selected");
	$(this).addClass("selected");
	layoutsColors();
});

// sidebar color  localstorage
$('.changeSideBarColor').on('click', function () {
    var selectedColor = $(this).attr('data-color');
    if (selectedColor == 'default') {
        localStorage.removeItem('sidebarColor'); 
        $('.sidebar').removeAttr('data-background-color');
    } else {
        localStorage.setItem('sidebarColor', selectedColor);
        $('.sidebar').attr('data-background-color', selectedColor);
    }
    $(this).parent().find('.changeSideBarColor').removeClass("selected");
    $(this).addClass("selected");
    layoutsColors(); 
});


// background color
$('.changeBackgroundColor').on('click', function () {

	var bgColor= $(this).attr('data-color')

	localStorage.removeItem('bodyColor');
	$('body').removeAttr('data-background-color');

	$('body').attr('data-background-color', bgColor);
	localStorage.setItem('bodyColor', bgColor);

	$(this).parent().find('.changeBackgroundColor').removeClass("selected");
	$(this).addClass("selected");
});

function customCheckColor() {
	var logoHeader = $('.logo-header').attr('data-background-color');
	if (logoHeader !== "white") {
		$('.logo-header .navbar-brand').attr('src', '../../assets/img/logo.svg');
	} else {
		$('.logo-header .navbar-brand').attr('src', '../../assets/img/logo2.svg');
	}
}


var toggle_customSidebar = false,
	custom_open = 0;

if (!toggle_customSidebar) {
	var toggle = $('.custom-template .custom-toggle');

	toggle.on('click', (function () {
		if (custom_open == 1) {
			$('.custom-template').removeClass('open');
			toggle.removeClass('toggled');
			custom_open = 0;
		} else {
			$('.custom-template').addClass('open');
			toggle.addClass('toggled');
			custom_open = 1;
		}
	})
	);
	toggle_customSidebar = true;
}