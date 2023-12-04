import  { useState } from 'react';
import '../css/DataTable.css'

export default function DataTable({
                                      headers,
                                      items = [],
                                      selectable = false,
                                      itemKey,
                                      updateSelection = () => {},
                                  }) {
    // headers가 있는지 체크하고, 없다면 에러를 던짐
    if (!headers || !headers.length) {
        throw new Error('<DataTable /> headers is required.');
    }
    // value 순서에 맞게 테이블 데이터를 출력하기 위한 배열
    const headerKey = headers.map((header) => header.value);
    // itemKey가 없다면 headers의 첫번째 요소를 선택
    if (!itemKey) {
        itemKey = headerKey[0];
    }
    // 선택한 row의 itemKey를 담은 배열
    const [selection, setSelection] = useState(new Set());
    const onChangeSelect = (value) => {
        // 기존의 selection으로 새로운 Set 생성
        const newSelection = new Set(selection);
        if (newSelection.has(value)) {
            // value가 있으면 삭제 (checked가 false이기 때문)
            newSelection.delete(value);
        } else {
            // value가 없으면 추가 (checked가 true이기 때문)
            newSelection.add(value);
        }
        // 새로운 Set으로 state 변경
        setSelection(newSelection);
        updateSelection([...newSelection]);
    };
    // disabled가 true인 item만 반환하는 함수
    const getAbledItems = (items) => {
        return items.filter(({ disabled }) => !disabled);
    };
    const onChangeSelectAll = (e) => {
        if (e.target.checked) {
            // checked가 true인 경우 전체 선택
            const allCheckedSelection = new Set(
                // 활성화된 행의 배열을 순회하며 itemKey로 요소에 접근해 데이터를 저장
                getAbledItems(items).map((item) => item[itemKey])
            );
            setSelection(allCheckedSelection);
            updateSelection([...allCheckedSelection]);
        } else {
            // checked가 false인 경우 전체 선택 해제
            setSelection(new Set());
            updateSelection([]);
        }
    };
    // 전체 선택 상태 여부
    const isSelectedAll = () => {
        return selection.size === getAbledItems(items).length;
    };

    return (
        <table>
            <thead>
            <tr>
                {/* 선택 기능을 사용할 때만 바인딩 */}
                {selectable && (
                    <th>
                        <input
                            type="checkbox"
                            checked={isSelectedAll()}
                            onChange={onChangeSelectAll}
                        />
                    </th>
                )}
                {headers.map((header) => (
                    <th key={header.text}>
                        {header.text} {/* 컬럼명 바인딩 */}
                    </th>
                ))}
            </tr>
            </thead>
            <tbody>
            {items.map((item, index) => (
                <tr
                    key={index}
                    className={`
            ${selection.has(item[itemKey]) ? 'select_row' : ''} 
            ${item.disabled ? 'disabled_row' : ''}
          `}
                >
                    {/* 선택 기능을 사용할 때만 바인딩 */}
                    {selectable && (
                        <td>
                            <input
                                type="checkbox"
                                disabled={item.disabled}
                                checked={selection.has(item[itemKey])}
                                onChange={() => onChangeSelect(item[itemKey])}
                            />
                        </td>
                    )}
                    {/* headerKey를 순회하면서 key를 가져옴 */}
                    {headerKey.map((key) => (
                        <td key={key + index}>
                            {item[key]} {/* key로 객체의 값을 출력 */}
                        </td>
                    ))}
                </tr>
            ))}
            </tbody>
        </table>
    );
}

