import {useLocation, useParams} from "react-router-dom";
import {useState , useEffect} from "react";
import '../css/Table.css';
import DataTable from '../Component/dataTable';

const headers0 = [
    {
        text: '출발역',
        value: 'dep_sta',
    },
    {
        text: '도착역',
        value: 'arr_sta',
    },
];

const items0 = [
    {
        dep_sta: '부산역',
        arr_sta: '오송역',
    },
];


const headers1 = [
    {
        text: '출발시간',
        value: 'etd',
    },
    {
        text: '도착시간',
        value: 'eta',
    },
    {
        text: '가격',
        value: 'price',
    },
    {
        text: '이동시간',
        value: 'duration',
    },
];
const items1 = [
    {
        etd: '06:13',
        eta: '09:00',
        price: '38000',
        duration: '02:47',
    },
    {
        etd: '05:55',
        eta: '07:41',
        price: '34500',
        duration: '01:46',
    },
    {
        etd: '06:40',
        eta: '08:25',
        price: '34500',
        duration: '01:45',
    },
    {
        etd: '07:16',
        eta: '09:06',
        price: '34500',
        duration: '01:50',
    },
];

function Detail() {
    const {title} = useParams();
    const {state} = useLocation();
    const [selection0, setSelection0] = useState([]);
    const [selection1, setSelection1] = useState([]);
    useEffect(() => {
        console.log(selection0);
    }, [selection0]);
    useEffect(() => {
        console.log(selection1);
    }, [selection1]);

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
            <div className='price-info'>{state.price}</div>
            <div className='price-icon'>$</div>
            <div className='phone-info'>{state.phone}</div>
            <div className='phone-icon'>
                <img src={process.env.PUBLIC_URL + '/phone.png'} width = '45px' height = '50px'/>
            </div>
            <div className='fstvl-info'>{state.text}</div>
            <div className='fstvl-icon'>
                <img src={process.env.PUBLIC_URL + '/information.png'} width = '65px' height = '50px'/>
            </div>

            <div className="Table_lo">
            <DataTable
                headers={headers0}
                items={items0}
                updateSelection={setSelection0}
            />
            <DataTable
                headers={headers1}
                items={items1}
                updateSelection={setSelection1}
            />
            </div>
        </div>
    );
}

export default Detail;