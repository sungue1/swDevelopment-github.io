import axios from 'axios';
import Fstvl from '../Component/Fstvl';

import { useState , useEffect } from "react";

function Main() {
    const [fstvls, setFstvl] = useState(null);

    useEffect(() => {
        axios.get("http://localhost:8080/main")
            .then(response => setFstvl(response.data))
    },[]);

    return (
            <div>
                <div className = 'main-container'>
                        {fstvls && fstvls.map(fstvl => {
                                return(
                                    <Fstvl
                                        key = {fstvl.fstvl_id}
                                        title={fstvl.title}
                                        photo={fstvl.photo}
                                        date={fstvl.date}
                                        location={fstvl.location}
                                        price={fstvl.price}
                                        phone={fstvl.phone}
                                        text={fstvl.text}
                                        fstvl_keyword={fstvl.fstvl_keyword}
                                        fstvl_id={fstvl.fstvl_id}
                                    />
                                )
                        })}

                </div>
                <div>
                    <div className="key_date" />
                    {/*아직 미구현*/}
                    <div className="date_icon"></div>
                    {/*아직 미구현*/}
                    <div className="date_search"></div>
                    <div className="key_icon">#</div>
                    <div className="key_search"></div>
                    <div className="search">검색</div>
                    <div className="text_thisMonth">이 달의 축제</div>
                </div>
            </div>
    );
}

export default Main;