import '../css/Notfound.css'
function Notfound() {
    return (
        <div>
            <div className='not_text'>너, 링크 잘못 들어왔어 ㅋㅋ</div>
            <div className='notfound'>
                <img src={process.env.PUBLIC_URL + '/notfound2.jpg'} />
            </div>
        </div>
    );
}

export default Notfound;