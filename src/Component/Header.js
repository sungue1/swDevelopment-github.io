import { Link } from 'react-router-dom';

export default function Header(){
    return (
        <div className='head_back'>
            <Link to="/">
                <div className='logo'>C.T.P</div>
            </Link>

            <div className='script'>: 내가 원하는 축제를 몇 번의 클릭만으로</div>
            <input type={"text"} placeholder={"       축제 이름으로 검색하기..."} className='user-input'></input>

        </div>
    );
}