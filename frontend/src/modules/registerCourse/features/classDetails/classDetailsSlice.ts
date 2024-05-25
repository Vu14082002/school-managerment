import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { CancelToken } from 'axios';
import axiosClient from '../../../../api';
import { SUBJECT_ENDPOINT } from '../../constants';
import { IClass, IClassDetail, IGetClassDetails } from '../../interfaces';
import { convertDateClassDetail } from '../../utils';

interface ClassDetailsState {
    classSelected: IClass | null;
    classDetails: IClassDetail[];
    loading: boolean;
    error: string | null;
}

const initialState: ClassDetailsState = {
    classSelected: null,
    classDetails: [],
    loading: false,
    error: null,
};

const getClassDetails = createAsyncThunk(
    'getClassDetails',
    async ({ data, cancelToken }: { data: IGetClassDetails; cancelToken?: CancelToken }) => {
        const res = await axiosClient.post(
            `${SUBJECT_ENDPOINT}/DangKyHocPhan/DotDangKy/DanhSachHocPhan/LopHocPhanChoDangKy/ChiTietLopHocPhan`,
            data,
            {
                cancelToken,
            },
        );

        return res.data.data;
    },
);

const classDetails = createSlice({
    name: 'classDetails',
    initialState,
    reducers: {
        setClass: (state, { payload }: { payload: IClass | null }) => {
            state.classSelected = payload;
        },
        setClassDetails: (state, { payload }: { payload: IClassDetail[] }) => {
            state.classDetails = payload;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(getClassDetails.pending, (state) => {
            state.loading = true;
            state.error = null;
        });

        builder.addCase(getClassDetails.fulfilled, (state, action) => {
            state.loading = false;

            const classDetails: IClassDetail[] = action.payload || [];

            state.classDetails = classDetails.map((classDetail) => ({
                ...classDetail,
                lichHoc: convertDateClassDetail(classDetail.lichHoc),
            }));
        });

        builder.addCase(getClassDetails.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Cannot get class details';
            state.classDetails = [];
        });
    },
});

export default classDetails.reducer;
export const { setClass, setClassDetails } = classDetails.actions;
export { getClassDetails };
