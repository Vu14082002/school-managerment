import { ExoticComponent, ReactNode } from 'react';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import { Fragment } from 'react/jsx-runtime';
import { privateRoutes, publicRoutes } from './routes';

function App() {
    return (
        <Router>
            <Routes>
                {publicRoutes.map((route) => {
                    const Element = route.element;

                    return <Route key={route.path} path={route.path} element={<Element />} />;
                })}
                {privateRoutes.map((route) => {
                    const Element = route.element;
                    let Layout:
                        | ExoticComponent<{
                              children?: ReactNode | undefined;
                          }>
                        | (({ children }: { children: ReactNode }) => JSX.Element) = Fragment;

                    if (route.layout) Layout = route.layout;

                    return (
                        <Route
                            key={route.path}
                            path={route.path}
                            element={
                                <Layout>
                                    <Element />
                                </Layout>
                            }
                        />
                    );
                })}
            </Routes>
        </Router>
    );
}

export default App;
