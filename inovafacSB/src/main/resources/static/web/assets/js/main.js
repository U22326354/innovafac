(function () {
  //===== Prealoder

  window.onload = function () {
    window.setTimeout(fadeout, 500);
  };

  function fadeout() {
    document.querySelector(".preloader").style.opacity = "0";
    document.querySelector(".preloader").style.display = "none";
  }  /*=====================================
    Sticky
    ======================================= */
  // Pre-cargar las imágenes del logo para evitar problemas de carga
  const logoWhite = new Image();
  const logoDark = new Image();
  logoWhite.src = "/web/assets/img/logo/logo-white.png";
  logoDark.src = "/web/assets/img/logo/logo.png";

  window.onscroll = function () {
    const header_navbar = document.querySelector(".navbar-area");
    const logo = document.querySelector(".navbar-brand img");

    // Validar que los elementos existen
    if (!logo || !header_navbar) {
      console.error("Required elements not found!");
      return;
    }

    // Usar un threshold de 50px en lugar de offsetTop para mejor comportamiento
    const scrollThreshold = 50;

    console.log("Current scroll position:", window.pageYOffset);
    console.log("Scroll threshold:", scrollThreshold);
    console.log("Current logo src:", logo.src);

    if (window.pageYOffset > scrollThreshold) {
      header_navbar.classList.add("sticky");
      console.log("Adding sticky - changing to dark logo");
      // Para el header sticky (fondo blanco), usar logo oscuro
      logo.src = logoDark.src;
      console.log("Logo changed to:", logo.src);
    } else {
      header_navbar.classList.remove("sticky");
      console.log("Removing sticky - changing to white logo");
      // Para el header normal (fondo azul/oscuro), usar logo blanco
      logo.src = logoWhite.src;
      console.log("Logo changed to:", logo.src);
    }

    // show or hide the back-top-top button
    const backToTo = document.querySelector(".scroll-top");
    if (
      document.body.scrollTop > 50 ||
      document.documentElement.scrollTop > 50
    ) {
      backToTo.style.display = "flex";
    } else {
      backToTo.style.display = "none";
    }
  };

  // for menu scroll
  const pageLink = document.querySelectorAll(".page-scroll");

  pageLink.forEach((elem) => {
    elem.addEventListener("click", (e) => {
      e.preventDefault();
      document.querySelector(elem.getAttribute("href")).scrollIntoView({
        behavior: "smooth",
        offsetTop: 1 - 60,
      });
    });
  });

  // section menu active
  function onScroll(event) {
    const sections = document.querySelectorAll(".page-scroll");
    const scrollPos =
      window.pageYOffset ||
      document.documentElement.scrollTop ||
      document.body.scrollTop;

    for (let i = 0; i < sections.length; i++) {
      const currLink = sections[i];
      const val = currLink.getAttribute("href");
      const refElement = document.querySelector(val);
      const scrollTopMinus = scrollPos + 73;
      if (
        refElement.offsetTop <= scrollTopMinus &&
        refElement.offsetTop + refElement.offsetHeight > scrollTopMinus
      ) {
        document.querySelector(".page-scroll").classList.remove("active");
        currLink.classList.add("active");
      } else {
        currLink.classList.remove("active");
      }
    }
  }

  window.document.addEventListener("scroll", onScroll);

  //===== close navbar-collapse when a  clicked
  let navbarToggler = document.querySelector(".navbar-toggler");
  const navbarCollapse = document.querySelector(".navbar-collapse");

  document.querySelectorAll(".page-scroll").forEach((e) =>
    e.addEventListener("click", () => {
      navbarToggler.classList.remove("active");
      navbarCollapse.classList.remove("show");
    })
  );
  navbarToggler.addEventListener("click", function () {
    navbarToggler.classList.toggle("active");
  });

  // WOW active
  new WOW().init();
})();
