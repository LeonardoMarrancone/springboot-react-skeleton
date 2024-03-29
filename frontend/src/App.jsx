import React from 'react';
import axios from 'axios';
export const dataReducer = (state, action) => {
    if (action.type === 'SET_ERROR') {
        return { ...state, list: [], error: true };
    }
    if (action.type === 'SET_LIST') {
        return { ...state, list: action.list, error: null };
    }
    throw new Error();
};
const initialData = {
    list: [],
    error: null,
};
const App = () => {
    const [counter, setCounter] = React.useState(0);
    const [data, dispatch] = React.useReducer(dataReducer, initialData);
    React.useEffect(() => {
        axios
            .get('http://localhost:8080/list')
            .then(response => {
                dispatch({ type: 'SET_LIST', list: response.data });
            })
            .catch(() => {
                dispatch({ type: 'SET_ERROR' });
            });
    }, []);

    return (
        <div>
            <h2>My Counter</h2>
            <Counter counter={counter} />
            <button type="button" onClick={() => setCounter(counter + 1)}>
                Increment
      </button>
            <button type="button" onClick={() => setCounter(counter - 1)}>
                Decrement
      </button>
            <h2>The movies are:</h2>
            {data.error && <div className="error">Error</div>}
            <ul>
                {data.list.map((item, key) => (
                    <li key={key}><strong>{item.title}</strong> ({item.released}) - {item.tagline}</li>
                ))}
            </ul>
        </div>
    );
};
export const Counter = ({ counter }) => (
    <span>
        <p>{counter}</p>
    </span>
);
export default App;