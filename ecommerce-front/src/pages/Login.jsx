import { useNavigate } from 'react-router-dom'
import './Login.css'

export default function Login(){

    const navigate = useNavigate();

    function goToRegister(){
        navigate("/register")
    }

    return (
        <div class="container">

        <div class="card" id="login">

            <h2>Login</h2>

            <div class="input-group">
                <span>📧</span>
                <input type="email" placeholder="Email"/>
            </div>

            <div class="input-group">
                <span>🔒</span>
                <input type="password" placeholder="Senha"/>
            </div>

            <button>Logar</button>

            <button type="button" onClick={goToRegister}>CRIAR CONTA</button>
        </div>

        </div>
    )
}