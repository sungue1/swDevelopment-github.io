import {useLocation, useParams} from "react-router-dom";
import Fstvl from "../Component/Fstvl";
import {useState , useEffect} from "react";
import axios from "axios";
// import DataTable from './components/dataTable';


function Detail() {
    const {title} = useParams();
    const {state} = useLocation();
    // const [selection, setSelection] = useState([]);
    // useEffect(() => {
    //     console.log(selection);
    // }, [selection]);
    const headers = [
        {
            text: 'Name',
            value: 'name',
        },
        {
            text: 'Version',
            value: 'version',
        },
        {
            text: 'Launch Date',
            value: 'launch',
        },
    ];
    const items = [
        {
            name: 'React',
            version: '18.2.0',
            launch: '2013-05-29',
        },
        {
            name: 'Vue',
            version: '3.2.45',
            launch: '2014-02',
        },
        {
            name: 'jQuery',
            version: '3.3',
            disabled: true,
            launch: '2006-08-26',
        },
        {
            name: 'Svelte',
            version: '3.53.1',
            launch: '2016-11-26',
        },
    ];

    const [fstvl, setFstvl] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8080/main/${state.fstvl_id}`,{
            method: "POST",
            body: JSON.stringify(state.fstvl_id)
        })
            .then((response) => response.json())
            .then((data) => setFstvl(data));
    },[]);


    return (
        <div>
            <div className='title-info'>{title}</div>
            <div className='pic-info'>
                <img src = {state.photo} width = '400px' height = '450px' />
            </div>
            <div className='date-info'>{state.date}</div>
            <div className='date-icon'>
                <img src={process.env.PUBLIC_URL + '/date.png'} width = '50px' height = '50px'/>
            </div>
            <div className='location-info'>{state.location}</div>
            <div className='location-icon'>
                <img src={process.env.PUBLIC_URL + '/location.png'} width = '45px' height = '50px'/>
            </div>
            <div className='price-info'>{fstvl.price}</div>
            <div className='price-icon'>$</div>
            <div className='phone-info'>{fstvl.phone}</div>
            <div className='phone-icon'>
                <img src={process.env.PUBLIC_URL + '/phone.png'} width = '45px' height = '50px'/>
            </div>
            <div className='fstvl-info'>{fstvl.text}</div>
            <div className='fstvl-icon'>
                <img src={process.env.PUBLIC_URL + '/information.png'} width = '65px' height = '50px'/>
            </div>
            {/*<DataTable*/}
            {/*    headers={headers}*/}
            {/*    items={items}*/}
            {/*    selectable={true}*/}
            {/*    // updateSelection={setSelection}*/}
            {/*/>*/}
            </div>
    );
}

export default Detail;