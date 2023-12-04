import {useLocation, useParams} from "react-router-dom";
import {useState , useEffect} from "react";
import DataTable from '../Component/DataTable';
import Loading from "../Component/Loading";
import axios from "axios";
import '../css/Detail.css';

const headers0 = [{text: '출발역', value: 'dep'}, {text: '도착역', value: 'arr',}];
const headers1 = [
    {text: '출발시간', value: 'etd'},
    {text: '도착시간', value: 'eta'},
    {text: '가격', value: 'price'},
    {text: '이동시간', value: 'duration'},
];

function Detail() {
    const {title} = useParams();
    const {state} = useLocation();
    const [selection0, setSelection0] = useState([]);
    const [selection1, setSelection1] = useState([]);
    const [detailfstvl, setdetailFstvl] = useState('1');
    const [trains, setTrains] = useState([]);
    const [loading, setLoading] = useState(true);

    // useEffect(() => {
    //     console.log(selection0);
    // }, [selection0]);
    // useEffect(() => {
    //     console.log(selection1);
    // }, [selection1]);

    const fetchData = async () => {
        try {
            setLoading(true);
            const response_detail = await axios.post(`http://localhost:8080/main/${state.fstvl_id}`);
            setdetailFstvl(response_detail.data);
            const response_train = await axios.get(`http://localhost:8080/detail/${1}/${state.fstvl_id}`);
            setTrains(response_train.data);
            console.log(response_train);
        } catch (error) {
            console.error("Error fetching data:", error);
        } finally {
            console.log(trains);
            setLoading(false);
        }
    }
    useEffect(() => {
        fetchData();
    }, []);

    const headers2 = [
        { text: '출발지', value: 'dep' },
        { text: '도착지', value: 'arr' },
        { text: '출발시간', value: 'etd' },
        { text: '도착시간', value: 'eta' },
        { text: '가격', value: 'price' },
        { text: '이동시간', value: 'duration' },
    ];

    const transformTrainData = (trainData) => {
        const uniqueStations = Array.from(new Set(trainData.map(train => train.dep + train.arr)));

        return uniqueStations.map(uniqueStation => {
            const matchingTrains = trainData.filter(train => train.dep + train.arr === uniqueStation);

            return {
                stations: {
                    dep: matchingTrains[0].dep,
                    arr: matchingTrains[0].arr,
                },
                details: matchingTrains,
            };
        });
    };

    return (
        <div>
            {loading ? <Loading /> : null}
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
            <div className='price-info'>{detailfstvl.price}</div>
            <div className='price-icon'>$</div>
            <div className='phone-info'>{detailfstvl.phone}</div>
            <div className='phone-icon'>
                <img src={process.env.PUBLIC_URL + '/phone.png'} width = '45px' height = '50px'/>
            </div>
            <div className='fstvl-info'>{detailfstvl.text}</div>
            <div className='fstvl-icon'>
                <img src={process.env.PUBLIC_URL + '/information.png'} width = '65px' height = '50px'/>
            </div>
            <div className="Table_lo" style={{ display: 'flex', flexDirection: 'row' }}>
                {transformTrainData(trains).map((data, index) => (
                    <div key={index} style={{ marginRight: '20px' }}>
                        <DataTable
                            headers={headers0}
                            items={[data.stations]}
                            updateSelection={setSelection0}
                        />
                        <DataTable
                            headers={headers1}
                            items={data.details}
                            updateSelection={setSelection1}
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Detail;