import { ReactNode } from 'react';

interface Route {
    path: string;
    element: () => JSX.Element;
    layout?: ({ children }: { children: ReactNode }) => JSX.Element;
}

export default Route;
