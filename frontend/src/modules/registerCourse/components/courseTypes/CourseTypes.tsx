import { useMemo } from 'react';
import { ICourseType } from '../../interfaces';
import CourseType from './CourseType';

const CourseTypes = ({ types }: { types: ICourseType[] }) => {
    const renderTypes = useMemo(() => {
        const res: {
            [key: string]: string[];
        } = {
            a: [],
            b: [],
            c: [],
        };

        types.forEach((type) => res[type.type].push(type.id));

        return res;
    }, [types]);

    return (
        <div className="flex items-center justify-center">
            {Object.keys(renderTypes).map((key) => (
                <CourseType
                    key={key}
                    type={{
                        id: renderTypes[key].join(','),
                        type: key as 'a' | 'b' | 'c',
                    }}
                />
            ))}
        </div>
    );
};

export default CourseTypes;
