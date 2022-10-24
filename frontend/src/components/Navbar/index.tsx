import { ReactComponent as GitubIcon } from "assets/img/github.svg";
import './style.css'

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-content">
          <h1>DSMovie</h1>
          <a href="https://github.com/ufelps">
            <div className="dsmovie-contact-container">
              <GitubIcon></GitubIcon>
              <p className="dsmovie-contact-link">/uFelps</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
