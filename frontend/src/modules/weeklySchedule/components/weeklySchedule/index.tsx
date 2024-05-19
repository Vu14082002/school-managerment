import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { useState } from 'react';
import styles from './style.module.css';
import classNames from 'classnames/bind';
import Header from '../../../../components/header';
const cx = classNames.bind(styles);

export default function WeeklySchedule() {
    const [showDatePicker, setShowDatePicker] = useState(false);
    const [date, setDate] = useState(new Date());

    return (
        <div className={`${cx('weekly-schedule-wrapper')} mx-auto flex flex-col items-center`}>
            <Header />
            <div className={`bg-white rounded-sm p-4 ${cx('weekly-schedule-container')}`}>
                <h2 className={`font-semibold mb-3 text-xl`}>Lịch học, lịch thi theo tuần</h2>
                <div className="text-right justify-end flex items-center pb-3">
                    <div className="flex items-center">
                        <div className="flex items-center mr-5">
                            <input
                                type="radio"
                                name="type"
                                className="radio radio-info radio-sm"
                                id="hs-radio-group-1"
                                defaultChecked
                            />
                            <label
                                htmlFor="hs-radio-group-1"
                                className="text-sm text-gray-700 ms-2 dark:text-neutral-600"
                            >
                                Tất cả
                            </label>
                        </div>
                        <div className="flex items-center mr-5">
                            <input
                                type="radio"
                                name="type"
                                className="radio radio-info radio-sm"
                                id="hs-radio-group-2"
                            />
                            <label
                                htmlFor="hs-radio-group-2"
                                className="text-sm text-gray-700 ms-2 dark:text-neutral-600"
                            >
                                Lịch học
                            </label>
                        </div>
                        <div className="flex items-center mr-5">
                            <input
                                type="radio"
                                name="type"
                                className="radio radio-info radio-sm"
                                id="hs-radio-group-3"
                            />
                            <label
                                htmlFor="hs-radio-group-3"
                                className="text-sm text-gray-700 ms-2 dark:text-neutral-600"
                            >
                                Lịch thi
                            </label>
                        </div>
                    </div>

                    <button
                        className="flex items-center border text-sm cursor-pointer"
                        onClick={() => setShowDatePicker(!showDatePicker)}
                    >
                        <DatePicker
                            selected={date}
                            onChange={(date: Date) => setDate(date)}
                            className="outline-none px-3 py-2 cursor-pointer w-[120px]"
                            open={showDatePicker}
                            onClickOutside={() => setShowDatePicker(false)}
                            dateFormat={'dd/MM/yyyy'}
                        />
                        <i className="ri-calendar-2-line px-2 border-l block text-lg pv-1 font-medium"></i>
                    </button>

                    <div className="ml-2 flex items-center gap-x-2">
                        <button className={`flex items-center gap-1 px-3 py-1 ${cx('action-btn')} text-white`}>
                            <i className="ri-calendar-todo-fill"></i>
                            <span className="text-sm">Hiện tại</span>
                        </button>

                        <button className={`flex items-center justify-center px-3 py-1 ${cx('action-btn')} text-white`}>
                            <i className="ri-arrow-left-s-line"></i>
                            <span className="text-sm">Trở về</span>
                        </button>

                        <button
                            className={`flex items-center justify-center gap px-3 py-1 ${cx('action-btn')} text-white`}
                        >
                            <span className="text-sm">Tiếp</span>
                            <i className="ri-arrow-right-s-line"></i>
                        </button>
                    </div>
                </div>

                <div className="pt-2 border-t">
                    <table className={`${cx('schedule-table')}`}>
                        <thead className={`${cx('schedule-table-header')}`}>
                            <tr className="flex">
                                <th
                                    className={`${cx(
                                        'schedule-table-header-cell',
                                        'schedule-table-header-cell-first',
                                    )}`}
                                >
                                    <p className="text-sm">Ca học</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 2</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 3</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 4</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 5</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 6</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Thứ 7</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                                <th className={`${cx('schedule-table-header-cell')} flex-1`}>
                                    <p className="text-sm">Chủ nhật</p>
                                    <p className="text-sm">01/01/2021</p>
                                </th>
                            </tr>
                        </thead>
                        <tbody className={`${cx('schedule-table-body')}`}>
                            <tr className={`${cx('schedule-table-row')} flex`}>
                                <td className={`${cx('schedule-table-cell', 'schedule-table-cell-first')}`}>Sáng</td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}>
                                    <div className={`${cx('course-item', 'theory-course')}`}>
                                        <p className={`${cx('course-name')}`}>Nhập môn dữ liệu lớn</p>
                                        <p className={`${cx('course-info')}`}>DHKTPM16A - 420300232905</p>
                                        <p className={`${cx('course-info')}`}>Tiết: 4 - 6</p>
                                        <p className={`${cx('course-info')}`}>Phòng: H4.1</p>
                                        <p className={`${cx('course-info')}`}>GV: Trần Quang Khải</p>
                                    </div>
                                </td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}>
                                    <div className={`${cx('course-item', 'exam-course')}`}>
                                        <p className={`${cx('course-name')}`}>Nhập môn dữ liệu lớn</p>
                                        <p className={`${cx('course-info')}`}>DHKTPM16A - 420300232905</p>
                                        <p className={`${cx('course-info')}`}>Nhóm: 1 (1-27)</p>
                                        <p className={`${cx('course-info')}`}>Tiết: 4 - 6</p>
                                        <p className={`${cx('course-info')}`}>Phòng: H4.1</p>
                                        <p className={`${cx('course-info')}`}>GV: Trần Quang Khải</p>
                                    </div>
                                </td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                            </tr>

                            <tr className={`${cx('schedule-table-row')} flex`}>
                                <td className={`${cx('schedule-table-cell', 'schedule-table-cell-first')}`}>Chiều</td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}>
                                    <div className={`${cx('course-item', 'practice-course')}`}>
                                        <p className={`${cx('course-name')}`}>Nhập môn dữ liệu lớn</p>
                                        <p className={`${cx('course-info')}`}>DHKTPM16A - 420300232905</p>
                                        <p className={`${cx('course-info')}`}>Tiết: 4 - 6</p>
                                        <p className={`${cx('course-info')}`}>Phòng: H4.1</p>
                                        <p className={`${cx('course-info')}`}>GV: Trần Quang Khải</p>
                                    </div>
                                </td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                            </tr>

                            <tr className={`${cx('schedule-table-row')} flex`}>
                                <td className={`${cx('schedule-table-cell', 'schedule-table-cell-first')}`}>Tối</td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}>
                                    <div className={`${cx('course-item', 'online-course')}`}>
                                        <p className={`${cx('course-name')}`}>Nhập môn dữ liệu lớn</p>
                                        <p className={`${cx('course-info')}`}>DHKTPM16A - 420300232905</p>
                                        <p className={`${cx('course-info')}`}>Tiết: 4 - 6</p>
                                        <p className={`${cx('course-info')}`}>Phòng: H4.1</p>
                                        <p className={`${cx('course-info')}`}>GV: Trần Quang Khải</p>
                                    </div>
                                </td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                                <td className={`${cx('schedule-table-cell')} flex-1`}></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div className={`flex items-center mt-5 gap-4`}>
                    <div className={`flex items-center gap-1`}>
                        <div className={`${cx('badge-theory-course')}`}></div>
                        <p className="text-xs">Lịch học lý thuyết</p>
                    </div>

                    <div className={`flex items-center gap-1`}>
                        <div className={`${cx('badge-practice-course')}`}></div>
                        <p className="text-xs">Lịch học thực hành</p>
                    </div>

                    <div className={`flex items-center gap-1`}>
                        <div className={`${cx('badge-online-course')}`}></div>
                        <p className="text-xs">Lịch học trực tuyến</p>
                    </div>

                    <div className={`flex items-center gap-1`}>
                        <div className={`${cx('badge-exam-course')}`}></div>
                        <p className="text-xs">Lịch thi</p>
                    </div>
                </div>
            </div>
        </div>
    );
}
