import { useNavigate } from "react-router-dom";
import { useState } from "react";
import '../css/Preview.css';

function Preview() {
    const [isHovering, setIsHovering] = useState(false);
    const navigate = useNavigate();
    const onClickItem = () => {navigate('/main')}
    const handleMouseOver = () => {setIsHovering(true)};
    const handleMouseOut = () => {setIsHovering(false)};

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

            <div
                className={isHovering ? 'find_button_hover' : 'find_button_nohover'}
                onClick = {onClickItem}
                onMouseOver={handleMouseOver}
                onMouseOut={handleMouseOut}
            >축제찾기</div>
        </div>
    );
}

export default Preview;