import { routes } from '../configs';
import { Route } from '../interfaces';
import DefaultLayout from '../layouts';
import Login from '../modules/auth';
import NotFound from '../components/notFound';
import RegisterCourse from '../modules/registerCourse';
import StudentDashboard from '../modules/studentDashboard';
import WeeklySchedule from '../modules/weeklySchedule';

const publicRoutes: Route[] = [
    { path: routes.notFound, element: NotFound },
    { path: routes.login, element: Login },
];
const privateRoutes: Route[] = [
    { path: routes.home, element: StudentDashboard },
    { path: routes.studentDashboard, element: StudentDashboard },
    { path: routes.weeklySchedule, element: WeeklySchedule },
    { path: routes.registerCourse, element: RegisterCourse, layout: DefaultLayout },
];

export { privateRoutes, publicRoutes };
