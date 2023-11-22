import { Link } from 'react-router-dom';

function Preview() {
    return (
        <div>
            <div className='background'>
                <img src={process.env.PUBLIC_URL + '/preview_background.jpg'} width = "100%" height = "100%"/>
            </div>
            <div className='pre_map'>
                <img src={process.env.PUBLIC_URL + '/preview_map.jpg'}/>
            </div>
            <div className='CTP'>
                <img src={process.env.PUBLIC_URL + '/CTP_background.png'} width = "70%"/>
            </div>
            <div className='CTP_text'>
                <div>Custom</div>
                <div>Travel</div>
                <div>Planner</div>
            </div>

            <Link to='main'>
                <div className='find_button'>축제찾기</div>
            </Link>
        </div>
    );
}

export default Preview;