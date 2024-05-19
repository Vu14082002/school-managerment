interface IRegisteredClass {
    id: string;
    name: string;
    class: string;
    credit: number;
    group?: number;
    fee: number;
    payment: boolean;
    deadline: string;
    status: string;
    registerDate: string;
    classStatus: string;
}

export default IRegisteredClass;
