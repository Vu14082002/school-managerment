import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { CancelToken } from 'axios';
import axiosClient from '../../../../api';
import { SUBJECT_ENDPOINT } from '../../constants';
import { IGetRegisteredClasses, IRegisteredClass } from '../../interfaces';
import { convertDateCLassRegistered } from '../../utils';

interface RegisteredClassesState {
    registeredClasses: IRegisteredClass[];
    loading: boolean;
    error: string | null;
}

const initialState: RegisteredClassesState = {
    registeredClasses: [],
    loading: false,
    error: null,
};

const getRegisteredClasses = createAsyncThunk(
    'getRegisteredClasses',
    async ({ data, cancelToken }: { data: IGetRegisteredClasses; cancelToken?: CancelToken }) => {
        const res = await axiosClient.post(`${SUBJECT_ENDPOINT}/DangKyHocPhan/DanhSachHocPhanDangKyTrongKy`, data, {
            cancelToken,
        });

        return res.data.data;
    },
);

const registeredClasses = createSlice({
    name: 'registeredClasses',
    initialState,
    reducers: {
        setRegisteredClasses: (state, { payload }: { payload: IRegisteredClass[] }) => {
            state.registeredClasses = payload;
        },
    },
    extraReducers: (builder) => {
        builder.addCase(getRegisteredClasses.pending, (state) => {
            state.loading = true;
            state.error = null;
        });

        builder.addCase(getRegisteredClasses.fulfilled, (state, action) => {
            state.loading = false;

            const registeredClasses: IRegisteredClass[] = action.payload || [];

            state.registeredClasses = registeredClasses.map((item) => ({
                ...item,
                ngayDK: convertDateCLassRegistered(item.ngayDK),
            }));
        });

        builder.addCase(getRegisteredClasses.rejected, (state, action) => {
            state.loading = false;
            state.error = action.error.message || 'Failed to fetch data';
        });
    },
});

export default registeredClasses.reducer;
export const { setRegisteredClasses } = registeredClasses.actions;
export { getRegisteredClasses };
